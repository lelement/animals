package com.example.animals.response;

import lombok.Data;

import java.util.List;

/**
 * Created by lemon on 2020-02-18 22:25.
 */
@Data
public class SelectGoodResponse {
    private List<GoodResponse> goodsList;
    private Long total;
}
