package com.sangyups.springPractice.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Utils {

  static public String toStringDateTime(LocalDateTime time) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    return Optional.ofNullable(time)
        .map(formatter::format)
        .orElse("");
  }
}
