package com.sky.service;
import com.sky.vo.TurnoverReportVO;

import java.time.LocalDate;
/**
 * 统计营业额的相关业务
 *
 * @author Li Yijia
 * @date 2024/4/18
 */
public interface ReportService {
    /**
     * 统计指定时间区间内的营业额数据
     * @param begin
     * @param end
     * @return
     */
    TurnoverReportVO getUserStatistics(LocalDate begin, LocalDate end);
}
