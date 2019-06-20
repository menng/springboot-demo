package org.springboot.demo.caffeine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
class Province {

    private Integer id;

    private String name;

    private String desc;

    private LocalDateTime date;
}
