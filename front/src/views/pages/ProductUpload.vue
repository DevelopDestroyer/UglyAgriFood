<template>
  <v-container fluid class="down-top-padding">
    <v-row>
      <v-col cols="12" lg="12">
        <v-card>
          <v-card-text>
            <h3 class="title blue-grey--text text--darken-2 font-weight-regular">판매 글쓰기</h3>
          </v-card-text>
          <v-divider></v-divider>
          <v-card-text>

            <v-text-field
              v-model="dtext"
              label="제목을 입력해주세요"
              filled
              background-color="transparent"
            ></v-text-field>
            <v-text-field
              type="number"
              v-model="emailtext"
              label="가격을 입력해주세요 (원 단위)"
              filled
              background-color="transparent"
            ></v-text-field>
            <v-textarea
              filled
              name="input-7-4"
              rows="3"
              label="상품소개"
              value
              background-color="transparent"
            ></v-textarea>
            <div class="mt-4">
              <v-select :items="items" filled label="카테고리를 선택해주세요" background-color="transparent"></v-select>
            </div>


            <div class="filebox">
              <label for="ex_file">상품 설명 이미지 업로드</label>
              <input type="file" id="ex_file" @change="explainImg = 1">
              <p v-if="explainImg == '' || explainImg == null">
                상품 설명 이미지를 첨부해주세요 !
              </p>
              <p v-else style="color: #00c853">
                상품 설명 이미지를 첨부하였습니다.
              </p>
            </div>

            <div class="filebox">
              <label for="th_file">썸네일 이미지 업로드</label>
              <input type="file" id="th_file" @change="thumbnailImg = 1">
              <p v-if="thumbnailImg == '' || thumbnailImg == null">
                썸네일 이미지를 첨부해주세요 ! (128 x 128 권장)
              </p>
              <p v-else style="color: #00c853">
                썸네일 이미지를 첨부하였습니다.
              </p>
            </div>


            <v-btn class="text-capitalize mt-5 element-0" color="#ff8a3d" style="width:100%; color:white;">완료</v-btn>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "Profile",

  data: () => ({
    explainImg : '',
    thumbnailImg : '',

    dtext: "",
    emailtext: "",
    password: "",
    disableinput: "",
    checkbox1: "",
    checkbox2: "",
    checkbox3: "",
    show1: false,
    rules: {
      required: value => !!value || "Required.",
      min: v => v.length >= 8 || "Min 8 characters",
      emailMatch: () => "The email and password you entered don't match"
    },
    items: ["쌀", "찹쌀", "콩", "팥", "녹두", "고구마", "감자", "배추"]
  }),
  components: {}
};
</script>
