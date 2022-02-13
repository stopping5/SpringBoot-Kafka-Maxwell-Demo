package com.stopping.kafkamaxwelldemo.POJO;

import lombok.Data;

@Data
public class Maxwell<T> {
        private String database;
        private String table;
        private String type;
        private long ts;
        private long xid;
        private boolean commit;
        private T data;
        private T old;
}
