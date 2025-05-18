package com.umc.week5.domain.member.service;

import com.umc.week5.global.apiPayload.code.status.ErrorStatus;
import com.umc.week5.global.apiPayload.exception.GeneralException;
import com.umc.week5.domain.food.FoodCategory;
import com.umc.week5.domain.food.FoodCategoryRepository;
import com.umc.week5.domain.mapping.MemberPrefer;
import com.umc.week5.domain.member.converter.MemberConverter;
import com.umc.week5.domain.member.converter.MemberPreferConverter;
import com.umc.week5.domain.member.dto.MemberRequestDTO;
import com.umc.week5.domain.member.entity.Member;
import com.umc.week5.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request){

        Member newMember = MemberConverter.toMember(request);

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new GeneralException(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
