package com.hpcl.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DealerRegisteredEvent {

    private String dealerCode;
    private String name;
    private String location;
}
