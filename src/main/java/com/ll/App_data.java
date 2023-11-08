package com.ll;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class App_data {
    private HashMap<Integer, Quote> data = new HashMap<>();

    public String selectList() {
        //entry : map의 key와 value를 모두 포함 / .map에서 항목별 String 생성 /
        //Collectors.joining(요소 사이사이 들어갈 문자열, 결과의 시작부분에 합쳐질 문자열, 결과의 끝부분에 합쳐질 문자열)
        String result = data.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> {
                    Quote quote = entry.getValue();
                    return String.format("%d / %s / %s / %s", entry.getKey(),
                            quote.getAuthor(), quote.getContent(), quote.getLocalDateTime());
                })
                .collect(Collectors.joining("\n", "번호 / 작가 / 명언\n----------------------\n", ""));

        return result;
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
