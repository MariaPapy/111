package org.example;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataContainer {
    public int year;
    public String name;
    public Boolean status;

    public void status(boolean b) {
    }
}

