package org.sh.huiyi.meeting.service.impl;

import jakarta.persistence.criteria.*;
import org.apache.commons.lang3.StringUtils;
import org.sh.huiyi.boot.utils.Result;
import org.sh.huiyi.meeting.dao.MeetingDao;
import org.sh.huiyi.meeting.model.Meeting;
import org.sh.huiyi.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    private MeetingDao meetingDao;

    @Override
    public Result getMeetingList(String name, Pageable pageable) {
        Map<String, Object> pageData = new HashMap<>();

        Specification<Meeting> specification = new Specification<Meeting>() {
            @Override
            public Predicate toPredicate(Root<Meeting> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(StringUtils.isNotBlank(name)) {
                    predicates.add(criteriaBuilder.like(root.get("name").as(String.class), "%" + name + "%"));
                }
                Order orderByCreateTime = criteriaBuilder.desc(root.get("createTime"));
                return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).orderBy(orderByCreateTime).getRestriction();
            }
        };

        Page<Meeting> meetingPage = meetingDao.findAll(specification, pageable);
        if(Objects.isNull(meetingPage)){
            return new Result("0", "操作成功", null);
        }
        List<Meeting> meetingList = meetingPage.getContent();
        pageData.put("totalCount", meetingPage.getTotalElements());
        pageData.put("curPage", pageable.getPageNumber() + 1);
        pageData.put("totalPages", meetingPage.getTotalPages());
        pageData.put("rows", meetingList);

        return new Result("0", "操作成功", pageData);
    }
}
