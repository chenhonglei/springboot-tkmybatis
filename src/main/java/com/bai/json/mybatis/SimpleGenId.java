package com.bai.json.mybatis;

import tk.mybatis.mapper.genid.GenId;

public class SimpleGenId implements GenId<Long> {
    private Long    time;
    private Integer seq;
    @Override
    public Long genId(String s, String s1) {
        long current = System.currentTimeMillis();
        if (time == null || time != current) {
            time = current;
            seq = 1;
        } else if (current == time) {
            seq++;
        }
        return (time << 20) | seq;
    }
}
