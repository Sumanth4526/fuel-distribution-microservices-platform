package com.hpcl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DealerRegisteredEvent {

    private String dealerCode;
    private String name;
    private String location;
}
