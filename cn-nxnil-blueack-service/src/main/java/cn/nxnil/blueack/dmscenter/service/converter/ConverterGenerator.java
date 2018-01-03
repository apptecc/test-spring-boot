package cn.nxnil.blueack.dmscenter.service.converter;

import cn.nxnil.blueack.dmscenter.model.ShopProductPromoInfo;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * 对象间转换工具<br>
 * VO -> Domain<br>
 * Domain -> VO<br>
 */
public class ConverterGenerator {

    public static void main(String[] args) {
        ConverterGenerator.generate(ShopProductPromoInfo.class, Objects.class);
    }

    public static void generate(Class<?> domain, Class<?> vo) {
        try {
            StringBuilder sbHeader = new StringBuilder();

//            sbHeader.append(buildPackage(domain));
            sbHeader.append(buildPackageOfThisClass());

            sbHeader.append(buildImports(domain, vo));
            sbHeader.append("public class " + domain.getSimpleName() + "Converter {\n\n");
            sbHeader.append(toVO(domain, vo));
            sbHeader.append(toVOs(domain, vo));
            sbHeader.append(toDomain(domain, vo));
            sbHeader.append(toDomains(domain, vo));
            sbHeader.append("}");

            String filename = buildFilePath(domain);

            writeFile(sbHeader.toString(), filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String buildPackage(Class<?> domain) {
        return "package " + domain.getPackage().getName() + ";\n\n";
    }

    private static String buildPackageOfThisClass() {
        return "package " + ConverterGenerator.class.getPackage().getName() + ";\n\n";
    }

    private static String buildFilePath(Class<?> domain) {
        return System.getProperty("user.dir") + File.separator + "cn-nxnil-blueack-service\\"
                + "src" + File.separator + "main" + File.separator + "java" + File.separator
                + ConverterGenerator.class.getPackage().getName().replaceAll("\\.", "\\\\") + File.separator
                + domain.getSimpleName() + "Converter.java";
    }

    private static void writeFile(String classContent, String filename) {
        PrintWriter pw = null;
        try {
            System.out.println(classContent);
            pw = new PrintWriter(new FileWriter(filename), false);
            pw.println(classContent);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }

    private static String buildImports(Class<?> domain, Class<?> vo) {
        StringBuilder sbImport = new StringBuilder();
        sbImport.append("import java.util.ArrayList;\n");
        sbImport.append("import java.util.Collection;\n");
        sbImport.append("import java.util.Collections;\n");
        sbImport.append("import java.util.List;\n");
        sbImport.append("import org.apache.commons.collections.CollectionUtils;\n");
        System.out.println(domain.getCanonicalName());
        sbImport.append("import " + domain.getName() + ";\n");
        sbImport.append("import " + vo.getName() + ";\n");
        sbImport.append("\n");
        return sbImport.toString();
    }

    private static String toVO(Class<?> domain, Class<?> vo) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(domain);
        PropertyDescriptor[] entityPDs = beanInfo.getPropertyDescriptors();
        beanInfo = Introspector.getBeanInfo(vo);
        PropertyDescriptor[] dtoPDs = beanInfo.getPropertyDescriptors();

        StringBuilder sbEntity2Dto = new StringBuilder();
        sbEntity2Dto.append("public static final " + vo.getSimpleName() + " toVO(" + domain.getSimpleName()
                + " domain) {\n");
        sbEntity2Dto.append("if (null == domain) {\n");
        sbEntity2Dto.append("return null;");
        sbEntity2Dto.append("}");
        sbEntity2Dto.append(vo.getSimpleName() + " vo = new " + vo.getSimpleName() + "();\n");
        PropertyDescriptor foundPD = null;
        for (PropertyDescriptor dtoPD : dtoPDs) {
            if ("class".equals(dtoPD.getName())) {
                continue;
            }
            foundPD = findCorrespondingPD(entityPDs, dtoPD.getName());
            if (foundPD != null) {
                sbEntity2Dto.append("vo." + dtoPD.getWriteMethod().getName() + "(domain."
                        + foundPD.getReadMethod().getName() + "());\n");
            }
        }
        sbEntity2Dto.append("return vo;\n}\n");
        return sbEntity2Dto.toString();
    }

    private static String toVOs(Class<?> domain, Class<?> vo) {
//        String dtoInterface = dto.getInterfaces()[0].getSimpleName();
        String dtoInterface = vo.getSimpleName();
        StringBuilder sbEntity2Dtos = new StringBuilder();
        sbEntity2Dtos.append("public static final List<" + dtoInterface + "> toVOs(Collection<"
                + domain.getSimpleName() + "> domains) {\n");
        sbEntity2Dtos.append("if (CollectionUtils.isEmpty(domains)) {\n");
        sbEntity2Dtos.append("return Collections.<" + dtoInterface + "> emptyList();\n");
        sbEntity2Dtos.append("}\n");
        sbEntity2Dtos.append("List<" + dtoInterface + "> vos = new ArrayList<>(domains.size());\n");
        sbEntity2Dtos.append("for (" + domain.getSimpleName() + " domain : domains) {\n");
        sbEntity2Dtos.append("vos.add(toVO(domain));\n");
        sbEntity2Dtos.append("}\n");
        sbEntity2Dtos.append("return vos;\n}\n");
        return sbEntity2Dtos.toString();
    }

    private static String toDomain(Class<?> domain, Class<?> vo) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(domain);
        PropertyDescriptor[] entityPDs = beanInfo.getPropertyDescriptors();
        beanInfo = Introspector.getBeanInfo(vo);
        PropertyDescriptor[] dtoPDs = beanInfo.getPropertyDescriptors();

//        String dtoInterface = dto.getInterfaces()[0].getSimpleName();
        String dtoInterface = vo.getSimpleName();
        StringBuilder sbDto2Entity = new StringBuilder();
        sbDto2Entity.append("public static final " + domain.getSimpleName() + " toDomain(" + dtoInterface + " vo) {\n");
        sbDto2Entity.append("if (null == vo) {\n");
        sbDto2Entity.append("return null;");
        sbDto2Entity.append("}");
        sbDto2Entity.append(domain.getSimpleName() + " domain = new " + domain.getSimpleName() + "();\n");
        PropertyDescriptor foundPD = null;
        for (PropertyDescriptor entityPD : entityPDs) {
            if ("class".equals(entityPD.getName())) {
                continue;
            }
            foundPD = findCorrespondingPD(dtoPDs, entityPD.getName());
            if (foundPD != null) {
                sbDto2Entity.append("domain." + entityPD.getWriteMethod().getName() + "(vo."
                        + foundPD.getReadMethod().getName() + "());\n");
            }
        }
        sbDto2Entity.append("return domain;\n}\n");
        return sbDto2Entity.toString();
    }

    private static String toDomains(Class<?> domain, Class<?> vo) {
//        String dtoInterface = dto.getInterfaces()[0].getSimpleName();
        String dtoInterface = vo.getSimpleName();
        StringBuilder sbDto2Entities = new StringBuilder();
        sbDto2Entities.append("public static final List<" + domain.getSimpleName() + "> toDomains(Collection<"
                + dtoInterface + "> vos) {\n");
        sbDto2Entities.append("if (CollectionUtils.isEmpty(vos)) {\n");
        sbDto2Entities.append("return Collections.<" + domain.getSimpleName() + "> emptyList();\n");
        sbDto2Entities.append("}\n");
        sbDto2Entities.append("List<" + domain.getSimpleName() + "> domains = new ArrayList<>(vos.size());\n");
        sbDto2Entities.append("for (" + dtoInterface + " vo : vos) {\n");
        sbDto2Entities.append("domains.add(toDomain(vo));\n");
        sbDto2Entities.append("}\n");
        sbDto2Entities.append("return domains;\n}\n");
        return sbDto2Entities.toString();
    }

    private static PropertyDescriptor findCorrespondingPD(PropertyDescriptor[] pds, String name) {
        for (PropertyDescriptor propertyDescriptor : pds) {
            if (propertyDescriptor.getName().equals(name)) {
                return propertyDescriptor;
            }
        }
        return null;
    }

}
