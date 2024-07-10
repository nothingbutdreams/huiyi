package org.sh.huiyi.service.impl;

import jakarta.persistence.criteria.*;
import org.apache.commons.lang3.StringUtils;
import org.sh.huiyi.boot.utils.DateUtil;
import org.sh.huiyi.boot.utils.Result;
import org.sh.huiyi.dao.MeetingReservationDao;
import org.sh.huiyi.model.MeetingReservation;
import org.sh.huiyi.service.MeetingReservationService;
import org.sh.huiyi.vo.MeetingReservationVo;
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

    @Override
    public Result getMeetingReservationById(String id) {
        MeetingReservationVo meetingReservationVo = new MeetingReservationVo();
        MeetingReservation meetingReservation = meetingReservationDao.findById(id);
        if(Objects.nonNull(meetingReservation)){
            meetingReservationVo.setId(meetingReservation.getId());
            meetingReservationVo.setMeetingId(meetingReservation.getMeeting().getId());
            meetingReservationVo.setMeetingName(meetingReservation.getMeeting().getMeetingName());
            meetingReservationVo.setStartTime(DateUtil.dateToString(meetingReservation.getMeeting().getStartTime(), DateUtil.DateStyle.YYYY_MM_DD_HH_MM_SS));
            meetingReservationVo.setEndTime(DateUtil.dateToString(meetingReservation.getMeeting().getEndTime(), DateUtil.DateStyle.YYYY_MM_DD_HH_MM_SS));
            meetingReservationVo.setPersName(meetingReservation.getPersName());
            meetingReservationVo.setMobile(meetingReservation.getMobile());
            meetingReservationVo.setRemark(meetingReservation.getRemark());
            meetingReservationVo.setState(meetingReservation.getState());

            return new Result("0", "操作成功", meetingReservationVo);
        }
        return new Result("0", "操作成功");
    }
}
