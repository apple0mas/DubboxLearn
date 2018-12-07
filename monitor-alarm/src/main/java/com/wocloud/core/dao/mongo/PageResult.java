package com.wocloud.core.dao.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Auther: apple0mas
 * @Date: 2018/11/9 18:02
 * @Description: 分页结果.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {

    private Integer pageNum;

    private Integer pageSize;

    private Long total;

    private Integer pages;

    private List<T> list;

}
