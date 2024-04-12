import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.sql.Date;

public class TimeGen {
    public static void main(String[] args) {
        // 快速生成数据库查询当天日期，格式如 时间类型"2024-04-12"
        LocalDate sqlToday = LocalDate.now(); // 获取当前日期，不包含时间
        Date sqlDate = Date.valueOf(sqlToday); // 转换 LocalDate 到 java.sql.Date
        System.out.println("SQL Today's date (java.sql.Date): " + sqlDate.toString());

        // 快速生成当天日期，格式如 字符串类型"2024-04-12"
        LocalDate strToday = LocalDate.now();  // 获取当前日期
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = strToday.format(dateFormatter);  // 格式化日期
        System.out.println("String Today's date (String): " + formattedDate);

        // 快速生成当前时间戳
        long currentTimeStamp = Instant.now().toEpochMilli();  // 获取当前时间戳（毫秒）
        System.out.println("Current Timestamp (long): " + currentTimeStamp);

        // 快速生成当前时间的详细日期时间字符串
        LocalDateTime now = LocalDateTime.now();  // 获取当前日期和时间
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(dateTimeFormatter);  // 格式化日期时间
        System.out.println("Current DateTime (String): " + formattedDateTime);
    }
}
