package com.hyunjung.finalproject.core.domain.entity;

import com.hyunjung.finalproject.core.domain.Event;
import com.hyunjung.finalproject.core.domain.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "engagement")
@Entity
public class Engagement extends BaseEntity{


    @JoinColumn(name = "schedule_id")
    @ManyToOne
    private Schedule schedule;

    @JoinColumn(name = "attendee_id")
    @ManyToOne
    private User attendee;

    @Enumerated(value = EnumType.STRING)
    private RequestStatus requestStatus;

    public Event getEvent() { return  schedule.toEvent(); }


}
