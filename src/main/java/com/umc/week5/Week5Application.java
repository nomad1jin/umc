package com.umc.week5;

import com.umc.week5.domain.enums.MissionStatus;
import com.umc.week5.domain.mission.service.MissionQueryService;
import com.umc.week5.domain.review.service.ReviewQueryService;
import com.umc.week5.domain.store.service.StoreQueryService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week5Application {

	public static void main(String[] args) {
		SpringApplication.run(Week5Application.class, args);
	}


	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			StoreQueryService storeService = context.getBean(StoreQueryService.class);
			ReviewQueryService reviewService = context.getBean(ReviewQueryService.class);
			MissionQueryService missionService = context.getBean(MissionQueryService.class);

			// 파라미터 값 설정
			String name = "요아정";
			Float score = 4.0f;

			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Score: " + score);

			storeService.findStoresByNameAndScore(name, score)
					.forEach(System.out::println);

			// 리뷰 전체 조회
			System.out.println("== Review 전체 조회 ==");
			reviewService.findall()
					.forEach(System.out::println);


			System.out.println("== CHALLENGING 미션 목록 ==");
			missionService.findMissionsByMemberMissionStatus(MissionStatus.CHALLENGING)
					.forEach(System.out::println);

			System.out.println("== COMPLETE 미션 목록 ==");
			missionService.findMissionsByMemberMissionStatus(MissionStatus.COMPLETE)
					.forEach(System.out::println);
		};


	}

}
