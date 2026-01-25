package Kiemthu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {

    // Khởi tạo đối tượng cần test
    private final StudentAnalyzer analyzer = new StudentAnalyzer();

    // --- TEST CASE 1: Hàm đếm học sinh giỏi ---

    @Test
    public void testCountExcellentStudents_Normal() {
        // Danh sách hỗn hợp: 9.0 (Giỏi), 8.5 (Giỏi), 7.0 (Khá), 11.0 (Sai), -1.0 (Sai)
        // Mong đợi: 2 học sinh giỏi
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_Empty() {
        // Danh sách rỗng -> Mong đợi: 0
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    // --- TEST CASE 2: Hàm tính điểm trung bình ---

    @Test
    public void testCalculateValidAverage_Normal() {
        // Điểm hợp lệ: 9.0 và 7.0 -> Tổng 16.0 / 2 = 8.0
        // Điểm sai: 15.0 và -5.0 bị loại
        List<Double> scores = Arrays.asList(9.0, 7.0, 15.0, -5.0);
        assertEquals(8.0, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testCalculateValidAverage_AllInvalid() {
        // Toàn bộ điểm sai -> Không tính được -> Mong đợi: 0.0
        List<Double> scores = Arrays.asList(-1.0, 11.0, 20.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.01);
    }
}