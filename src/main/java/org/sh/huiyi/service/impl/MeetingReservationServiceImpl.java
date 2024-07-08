package org.sh.huiyi.service.impl;

import jakarta.persistence.criteria.*;
import org.apache.commons.lang3.StringUtils;
import org.sh.huiyi.boot.utils.Result;
import org.sh.huiyi.dao.MeetingReservationDao;
import org.sh.huiyi.model.MeetingReservation;
import org.sh.huiyi.service.MeetingReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class MeetingReservationServiceImpl implements MeetingReservationService {

    @Autowired
    private MeetingReservationDao meetingReservationDao;

    @Override
    public Result getMeetingReservationList(String name, Pageable pageable) {
        Map<String, Object> pageData = new HashMap<>();

        Specification<MeetingReservation> specification = new Specification<MeetingReservation>() {
            @Override
            public Predicate toPredicate(Root<MeetingReservation> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(StringUtils.isNotBlank(name)) {
                    predicates.add(criteriaBuilder.like(root.get("name").as(String.class), "%" + name + "%"));
                }
                Order orderByCreateTime = criteriaBuilder.desc(root.get("createTime"));
                return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).orderBy(orderByCreateTime).getRestriction();
            }
        };

        Page<MeetingReservation> meetingRedervationPage = meetingReservationDao.findAll(specification, pageable);
        if(Objects.isNull(meetingRedervationPage)){
            return new Result("0", "操作成功", null);
        }
        List<MeetingReservation> meetingReservationList = meetingRedervationPage.getContent();
        pageData.put("totalCount", meetingRedervationPage.getTotalElements());
        pageData.put("curPage", pageable.getPageNumber() + 1);
        pageData.put("totalPages", meetingRedervationPage.getTotalPages());
        pageData.put("rows", meetingReservationList);

        return new Result("0", "操作成功", pageData);
    }
}
