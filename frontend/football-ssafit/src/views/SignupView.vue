<template>

    <section class="text-center text-lg-start">

        <!-- Jumbotron -->
        <div class="container py-4">
            <div class="row g-0 align-items-center">
                <div class="col-lg-6 mb-5 mb-lg-0">
                    <div class="card cascading-right bg-body-tertiary" style="
          backdrop-filter: blur(30px);
          ">
                        <div class="card-body p-5 shadow-5 text-center">
                            <h2 class="fw-bold mb-5">Sign up now</h2>
                            <form @submit.prevent="trySignup">




                                <!-- 아이디 -->
                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="text" id="userid" class="form-control"
                                        v-model="trySignupUser.userid" />
                                    <label class="form-label" for="userid">ID</label>
                                </div>

                                <!-- 비밀번호 -->
                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="password" id="form3Example4" class="form-control"
                                        v-model="trySignupUser.password" />
                                    <label class="form-label" for="form3Example4">Password</label>
                                </div>

                                <!-- 비밀번호 확인 -->
                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="password" id="passwordcheck" class="form-control"
                                        v-model="trySignupUser.passwordcheck" />
                                    <label class="form-label" for="passwordcheck">Check Password</label>
                                </div>


                                <!-- Email input -->
                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="email" id="form3Example3" class="form-control"
                                        v-model="trySignupUser.email" />
                                    <label class="form-label" for="form3Example3">Email address</label>
                                </div>


                                <!-- Email input -->
                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="text" id="name" class="form-control" v-model="trySignupUser.name" />
                                    <label class="form-label" for="name">Name</label>
                                </div>

                                <!-- 전화번호 -->
                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="tel" id="phone" class="form-control"
                                        v-model="trySignupUser.phoneNumber" />
                                    <label class="form-label" for="phone">phoneNumber</label>
                                </div>

                                <div class="row">
                                    <!-- Position 선택 -->
                                    <div class="mb-4">
                                        <label for="position">선호 포지션</label>
                                        <select id="position" v-model="trySignupUser.position">
                                            <option value="" disabled>-- 선택하세요 --</option>
                                            <option value="forward">공격수</option>
                                            <option value="midfield">미드필더</option>
                                            <option value="defense">수비수</option>
                                            <option value="goalkeeper">골키퍼</option>
                                        </select>
                                    </div>



                                    <!-- 권역 선택 -->
                                    <div class="col-md-4">
                                        <label for="region">권역 선택:</label>
                                        <select id="region" v-model="selectedRegion" @change="updateProvinces">
                                            <option value="">선택</option>
                                            <option v-for="region in regions" :key="region" :value="region">{{
                                                region }}
                                            </option>
                                        </select>
                                    </div>


                                    <!-- 도/시 선택 -->
                                    <div class="col-md-4">
                                        <label for="province">도/시 선택:</label>
                                        <select id="province" v-model="selectedProvince" @change="updateDistricts">
                                            <option value="">선택</option>
                                            <option v-for="province in provinces" :key="province" :value="province">
                                                {{
                                                    province }}</option>
                                        </select>
                                    </div>



                                    <div class="col-md-4">
                                        <!-- 구/군 선택 -->
                                        <label for="district">구/군 선택:</label>
                                        <select id="district" v-model="selectedDistrict">
                                            <option value="">선택</option>
                                            <option v-for="district in districts" :key="district" :value="district">
                                                {{
                                                    district }}</option>
                                        </select>
                                    </div>

                                </div>




                                <!-- Submit button -->
                                <button type="submit" data-mdb-button-init data-mdb-ripple-init
                                    class="btn btn-primary btn-block mt-4">
                                    Sign up
                                </button>


                            </form>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6 mb-5 mb-lg-0">
                    <video width="800" height="1100" autoplay muted loop>
                        <source
                            src="/src/assets/린가드영상.mp4"
                            type="video/mp4">
                        브라우저가 비디오 태그를 지원하지 않습니다.
                    </video>
                </div>
            </div>
        </div>
        <!-- Jumbotron -->
    </section>
    <!-- Section: Design Block -->

</template>

<script setup>
import { useUserStore } from '@/stores/user'; //유저 스토어 임포트
import { ref, computed } from 'vue';
const userstore = useUserStore() // 유저 스토어 사용




// 지역 데이터
const regiondata = {
    //
    수도권: {
        서울: ["강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"],
        경기: ["수원시 장안구", "수원시 권선구", "수원시 팔달구", "수원시 영통구", "성남시 수정구", "성남시 중원구", "성남시 분당구", "의정부시", "안양시 만안구", "안양시 동안구", "부천시", "광명시", "평택시", "동두천시", "안산시 상록구", "안산시 단원구", "고양시 덕양구", "고양시 일산동구",
            "고양시 일산서구", "과천시", "구리시", "남양주시", "오산시", "시흥시", "군포시", "의왕시", "하남시", "용인시 처인구", "용인시 기흥구", "용인시 수지구", "파주시", "이천시", "안성시", "김포시", "화성시", "광주시", "양주시", "포천시", "여주시", "연천군", "가평군",
            "양평군"],
        인천: ["계양구", "미추홀구", "남동구", "동구", "부평구", "서구", "연수구", "중구", "강화군", "옹진군"]
    },
    강원권: {
        강원: ["춘천시", "원주시", "강릉시", "동해시", "태백시", "속초시", "삼척시", "홍천군", "횡성군", "영월군", "평창군", "정선군", "철원군", "화천군", "양구군", "인제군", "고성군", "양양군"]
    },
    충청권: {
        충북: ["청주시 상당구", "청주시 서원구", "청주시 흥덕구", "청주시 청원구", "충주시", "제천시", "보은군", "옥천군", "영동군", "증평군", "진천군", "괴산군", "음성군", "단양군"],
        충남: ["천안시 동남구", "천안시 서북구", "공주시", "보령시", "아산시", "서산시", "논산시", "계룡시", "당진시", "금산군", "부여군", "서천군", "청양군", "홍성군", "예산군", "태안군"],
        대전: ["대덕구", "동구", "서구", "유성구", "중구"],
        세종: ["세종특별자치시"]
    },
    전라권: {
        전북: ["전주시 완산구", "전주시 덕진구", "군산시", "익산시", "정읍시", "남원시", "김제시", "완주군", "진안군", "무주군", "장수군", "임실군", "순창군", "고창군", "부안군"],
        전남: ["목포시", "여수시", "순천시", "나주시", "광양시", "담양군", "곡성군", "구례군", "고흥군", "보성군", "화순군", "장흥군", "강진군", "해남군", "영암군", "무안군", "함평군", "영광군", "장성군", "완도군", "진도군", "신안군"],
        광주: ["광산구", "남구", "동구", "북구", "서구"]
    },
    경상권: {
        경북: ["포항시 남구", "포항시 북구", "경주시", "김천시", "안동시", "구미시", "영주시", "영천시", "상주시", "문경시", "경산시", "군위군", "의성군", "청송군", "영양군", "영덕군", "청도군", "고령군", "성주군", "칠곡군", "예천군", "봉화군", "울진군", "울릉군"],
        경남: ["창원시 의창구", "창원시 성산구", "창원시 마산합포구", "창원시 마산회원구", "창원시 진해구", "진주시", "통영시", "사천시", "김해시", "밀양시", "거제시", "양산시", "의령군", "함안군", "창녕군", "고성군", "남해군", "하동군", "산청군", "함양군", "거창군", "합천군"],
        부산: ["강서구", "금정구", "남구", "동구", "동래구", "부산진구", "북구", "사상구", "사하구", "서구", "수영구", "연제구", "영도구", "중구", "해운대구", "기장군"],
        대구: ["남구", "달서구", "동구", "북구", "서구", "수성구", "중구", "달성군"],
        울산: ["남구", "동구", "북구", "중구", "울주군"]
    },
    제주권: {
        제주: ["서귀포시", "제주시"]
    }
};


// 선택된 값
const selectedRegion = ref("");
const selectedProvince = ref("");
const selectedDistrict = ref("");

// 권역 목록
const regions = computed(() => Object.keys(regiondata));

// 도/시 목록
const provinces = computed(() => {
    return selectedRegion.value ? Object.keys(regiondata[selectedRegion.value]) : [];
});

// 구/군 목록
const districts = computed(() => {
    return selectedProvince.value
        ? regiondata[selectedRegion.value][selectedProvince.value]
        : [];
});

// 도/시 및 구/군 초기화
const updateProvinces = () => {
    selectedProvince.value = "";
    selectedDistrict.value = "";
};

const updateDistricts = () => {
    selectedDistrict.value = "";
};

const trySignupUser = ref({ // 입력된 회원가입 정보
    userid: '',
    password: '',
    passwordcheck: '',
    email: '',
    phoneNumber: '',
    name: '',
    position: '',
    region: computed(() => selectedRegion.value),
    province: computed(() => selectedProvince.value),
    district: computed(() => selectedDistrict.value)
})
function trySignup() { // 로그인 시도
    if(!selectedRegion.value || !selectedProvince.value || !selectedDistrict.value){
        alert("시,군,구를 선택해주세요.")
    }
    else if(!trySignupUser.value.position){
        alert("선호 포지션을 선택해주세요.")
    }
    else{
        userstore.trySignup(trySignupUser.value)
    }
}

</script>

<style scoped>
.cascading-right {
    margin-right: -50px;
}

@media (max-width: 991.98px) {
    .cascading-right {
        margin-right: 0;
    }
}
</style>