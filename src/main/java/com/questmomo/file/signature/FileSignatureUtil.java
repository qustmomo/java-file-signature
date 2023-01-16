package com.questmomo.file.signature;

import java.util.ArrayList;
import java.util.List;

public class FileSignatureUtil {
    private final static FileSignatureEntity[] datas = FileSignatureDatas.datas;

    public static List<FileSignatureEntity> search(String[] str_codes) {
        List<FileSignatureEntity> rs = new ArrayList<>();
        if (str_codes == null || str_codes.length == 0) {
            return rs;
        }
        for (FileSignatureEntity entity : datas) {

            String[] entityCodes = entity.getCodes();
            int entity_skip = entity.getSkip();
            boolean flag = false;
            int min_len = Math.min(entityCodes.length, str_codes.length - entity_skip);
            for (int i = 0; i < min_len; i++) {
                String current_code = str_codes[i + entity_skip];
                flag = (entityCodes[i].charAt(0) == current_code.charAt(0) || entityCodes[i].charAt(0) == 'x')
                        && (
                        entityCodes[i].charAt(1) == current_code.charAt(1) || entityCodes[i].charAt(1) == 'x');

                if (flag) {
                    continue;
                }
                break;
            }
            if (flag) {
                rs.add(entity);
            }
        }
        return rs;
    }
}
