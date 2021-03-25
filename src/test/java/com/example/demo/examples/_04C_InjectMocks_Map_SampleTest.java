package com.example.demo.examples;

import com.example.demo.data.MyDictionary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class _04C_InjectMocks_Map_SampleTest {

    @InjectMocks
    MyDictionary dic = new MyDictionary();

    @Mock
    Map<String, String> wordMap;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void whenUseInjectMocksAnnotation_thenCorrect() {
        wordMap.put("aWord", "Central Processing Unit");
        when(wordMap.get("aWord")).thenReturn("hello");
        assertEquals("hello", dic.getMeaning("aWord"));
    }

}
