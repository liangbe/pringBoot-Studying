package com.bee.study.dao;

import com.bee.study.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by liangbe on 2017/4/13.
 */
@Repository
public interface EducationDao extends JpaRepository<Education,Long>{
}
