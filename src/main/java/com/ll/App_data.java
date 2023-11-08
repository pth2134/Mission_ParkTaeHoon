package com.ll;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;

@Getter
@Setter
public class App_data {
    private HashMap<Integer, Quote> data = new HashMap<>();

    public StringBuilder selectList() {
        StringBuilder sb = new StringBuilder();
        Integer[] keys = data.keySet().toArray(Integer[]::new);
        Arrays.sort(keys);
        sb.append("번호 / 작가 / 명언").append("\n")
                .append("----------------------").append("\n");
//        for (int i = 0; i < keys.length; i++) {
//            int quote_id = keys[i];
//            Data_table data_table = data.get(quote_id);
//            String author = data_table.getAuthor();
//            String content = data_table.getContent();
//            String localDateTime = data_table.getLocalDateTime();
//            sb.append(quote_id).append(" / ")
//                    .append(author).append(" / ")
//                    .append(content).append(" / ")
//                    .append(localDateTime).append("\n");
//        }
        //stream으로 고치기

        //"1 / 작자미상 / 현재를 사랑하라."
        return sb;
    }

    public boolean removeByQuoteId(int quoteId) {
        if (quoteId == 0) throw new NumberFormatException();
        if (!data.containsKey(quoteId)) return false;
        data.remove(quoteId);
        return true;
    }

    public Quote selectById(int quoteId) {
        return data.get(quoteId);
    }

    public void updateByQuoteId(int quoteId, Quote quote) {
        data.replace(quoteId, quote);
    }

    public boolean save() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("data.json"), data);
        } catch (IOException ioe) {
            return false;
        }
        return true;
    }

    public boolean load() throws NullPointerException{
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = Files.readString(Path.of("data.json"));
            TypeReference<HashMap<Integer, Quote>> typeReference = new TypeReference<>() {
            };
            data = objectMapper.readValue(json, typeReference);
        } catch (IOException ioe) {
            return false;
        }
        return true;
    }

}
