package cn.nxnil.blueack.dmscenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private Long id;
    private String locationCode;
    private String locationShortName;
    private String locationFullName;
}
