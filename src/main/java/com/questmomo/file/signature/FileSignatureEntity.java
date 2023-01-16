package com.questmomo.file.signature;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class FileSignatureEntity {

    private int skip = 0;

    private String codes_str ;
    private String[] codes ;
    private String file_type ;
    private String code_desc ;
    private String desc;


    public FileSignatureEntity(){
    }

    public FileSignatureEntity(int skip,String codes_str,String file_type,String code_desc,String desc){
        this.skip=skip;
        this.codes_str=codes_str;
        if (codes_str!=null){
            this.codes=codes_str.split(" ");
        }
        this.file_type=file_type;
        this.code_desc=code_desc;
        this.desc=desc;
    }

}
