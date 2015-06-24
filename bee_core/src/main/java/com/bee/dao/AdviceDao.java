package com.bee.dao;

import com.bee.pojo.Advice;
import com.qsd.framework.hibernate.JpaDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by suntongwei on 15/6/24.
 */
@Repository
public class AdviceDao extends JpaDaoSupport<Advice, Long> {
}
