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
              v-model="title"
              label="제목을 입력해주세요"
              filled
              background-color="transparent"
            ></v-text-field>
            <v-text-field
              type="number"
              v-model="price"
              label="가격을 입력해주세요 (원 단위)"
              filled
              background-color="transparent"
            ></v-text-field>
            <v-text-field
                v-model="producer"
                label="생산자를 입력해주세요 (ex. 해남농협)"
                filled
                background-color="transparent"
            ></v-text-field>
            <v-text-field
                v-model="productionArea"
                label="원산지를 입력해주세요 (ex. 충남 서산)"
                filled
                background-color="transparent"
            ></v-text-field>
            <v-text-field
                v-model="storageMethod"
                label="보관방법/취급방법을 입력해주세요 (ex. 상온보관)"
                filled
                background-color="transparent"
            ></v-text-field>
            <v-text-field
                v-model="weightPerUnit"
                label="개당 중량을 입력해주세요 (ex. 3kg)"
                filled
                background-color="transparent"
            ></v-text-field>
            <v-text-field
                v-model="composition"
                label="상품구성을 입력해주세요 (ex. 고구마 3kg, 1개)"
                filled
                background-color="transparent"
            ></v-text-field>
            <v-textarea
              filled
              name="input-7-4"
              rows="3"
              label="상품소개"
              v-model="introduction"
              background-color="transparent"
            ></v-textarea>
            <div class="mt-4">
              <v-select :items="items" v-model="category" filled label="카테고리를 선택해주세요" background-color="transparent"></v-select>
            </div>
            <br/>
            <div class="mt-4">
            <p style="font-size: 16px; color:#444444">생산년월일<br/>
              <input v-model="productionDate" type="date" id="start" name="trip-start"
                     min="2020-12-01" max="2020-12-31"></p>
            </div>

            <br/>
            <br/>

            <div class="filebox">
              <label for="ex_file" style="background-image: url(img/camera.png); width:80px; height:80px; background-color: white; border-color: white;"></label>
              <input type="file" id="ex_file" @change="explainImg = 1">
              <p v-if="explainImg == '' || explainImg == null">
                상품 설명 이미지를 첨부해주세요 !
              </p>
              <p v-else style="color: #00c853">
                상품 설명 이미지를 첨부하였습니다.
              </p>
            </div>

            <div class="filebox">
              <label for="th_file" style="background-image: url(img/camera.png); width:80px; height:80px; background-color: white; border-color: white;"></label>
              <input type="file" id="th_file" @change="thumbnailImg = 1">
              <p v-if="thumbnailImg == '' || thumbnailImg == null">
                썸네일 이미지를 첨부해주세요 ! (128 x 128 권장)
              </p>
              <p v-else style="color: #00c853">
                썸네일 이미지를 첨부하였습니다.
              </p>
            </div>


            <v-btn class="text-capitalize mt-5 element-0" @click="postProduct()" color="#ff8a3d" style="width:100%; color:white;">완료</v-btn>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import {BUS} from "@/views/pages/EventBus";

export default {
  name: "Profile",

  data: () => ({
    explainImg : '',
    thumbnailImg : '',

    title : '',
    category: '',
    price : 0,
    productionArea : '',
    productionDate : '2020-12-07',
    introduction : '',
    storageMethod : '',
    weightPerUnit : '',
    composition : '',
    producer : '',
    origin : '',

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
    items: [    "농산물",
      "수산물",
      "축산물",
      "가공품",
      "기타"]
  }),
  components: {},
  methods: {
    postProduct(){
      this.$store.dispatch('POST_PRODUCT_DATA', {
        category : this.category,
        introduction : this.introduction,
        price : this.price,
        productionArea : this.productionArea,
        productionDate : this.productionDate,
        title : this.title,
        userId : this.$store.state.userSeq,
        storageMethod : this.storageMethod,
        weightPerUnit : this.weightPerUnit,
        composition : this.composition,
        producer : this.producer,
        origin : this.productionArea
      }).then((result) => {
        if(result.data.statusCode == 'OK'){

          this.postFile(result.data.data.id);
        }
        console.log("결과" + result);//바깥 리설트
      })
    },
    postFile(id){
      let frm = new FormData();
      let photoFile = document.getElementById("ex_file");
      let photoFile2 = document.getElementById("th_file");
      frm.append("file", photoFile.files[0]);
      frm.append("file", photoFile2.files[0]);

      this.$store.dispatch('POST_FILE_DATA', {
        file : frm,
        id : id
      }).then((result) => {
        if(result.data.statusCode == 'OK'){
          BUS.$emit('alertModalOpen', '상품등록이 완료되었습니다.');
          location.href="/";
        }
        //console.log("결과2" + result);//바깥 리설트
      })
    }
  },
};
</script>
