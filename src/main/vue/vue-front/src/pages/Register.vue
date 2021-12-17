<template>
  <section class="container">
    <div class="section-title">회원가입</div>
    <div class="section-login-form">
      <div class="section-input-text">
        <i class="mdi mdi-at --grey"></i>
        <!-- <input type="text" placeholder="이메일주소"> -->
        <InputField
          ref="email"
          type="text"
          :value.sync="validate.email"
          placeholder="이메일 주소"
          fontSize="17"
          autocomplete="email"
        />
        <FieldErrorMsg v-if="emailErrMsg" :errMsg="emailErrMsg" />
      </div>
      <div class="section-input-text">
        <i class="mdi mdi-lock-open --grey"></i>
        <InputField
          ref="pw"
          type="password"
          :value.sync="validate.password"
          placeholder="비밀번호"
          fontSize="17"
          autocomplete="current-password"
        />
        <FieldErrorMsg v-if="pwErrMsg" :errMsg="pwErrMsg" />
      </div>
      <div class="section-input-text">
        <i class="mdi mdi-lock-open --grey"></i>
        <InputField
          ref="pw"
          type="password"
          :value.sync="validate.password2"
          placeholder="비밀번호확인"
          fontSize="17"
          autocomplete="current-password"
        />
        <FieldErrorMsg v-if="pwErrMsg" :errMsg="pwErrMsg2" />
      </div>
      <Button class="login-button" type="Blue" @click="register">회원가입</Button>
    </div>
  </section>
</template>

<script>
import FieldErrorMsg from "@/components/FieldErrorMsg";
import InputField from "@/components/InputField";
import Button from "@/components/Button";
import { reqRegister } from "@/utils/axios"

export default {
  name: "Login",
  data() {
    return {
      emailErrMsg: "",
      pwErrMsg: "",
      pwErrMsg2: "",
      emailPattern:
        /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
      validate: {
        email: "",
        password: "",
        password2: "",
      },
    };
  },
  components: {
    FieldErrorMsg,
    InputField,
    Button,
  },
  methods: {
    async register(e) {
      let check = true;
      if (!this.checker("pw")) check = false;
      if (!this.checker("pw2")) check = false;
      if (!this.checker("email")) check = false;
      if (!check) return;

      const result = await reqRegister.register( this.validate.email, this.validate.password)
      if(result.data.id > 0) {
        // this.$store.commit('setMember', result.data)
        this.$router.push('/login')
      } else {
        alert("회원가입에 실패하였습니다.")
      }
    },
    checker(type) {
      if (type === "email") {
        if (this.validate.email.length === 0) {
          return this.error(type, "이메일 주소를 입력해주세요.");
        } else if (this.validate.email.length > 24) {
          return this.error(
            type,
            "이메일 주소는 최대 24글자 까지 입력해주세요."
          );
        } else if (!this.emailPattern.test(this.validate.email)) {
          return this.error(type, "이메일 형식이 잘못되었습니다.");
        }
        this.emailErrMsg = "";
      } else if (type === "pw") {
        if (this.validate.password.length === 0) {
          return this.error(type, "비밀번호를 입력해주세요.");
        }
        if (this.validate.password.length < 8) {
          return this.error(type, "비밀번호를 8자 이상 입력해주세요.");
        }
        this.pwErrMsg = "";
      } else if (type === "pw2") {
        if (this.validate.password2 !== this.validate.password) {
          return this.error(type, "비밀번호가 일치하지 않습니다.");
        }
        this.pwErrMsg2 = "";
      }
      return true;
    },
    error(type, msg) {
      switch (type) {
        case "email":
          this.emailErrMsg = msg;
          this.$refs.email.focus();
          break;
        case "pw":
          this.pwErrMsg = msg;
          this.$refs.pw.focus();
          break;
      }
      return false;
    },
  },
  watch: {
    "validate.email": function () {
      if (this.emailErrMsg) {
        this.checker("email");
      }
    },
    "validate.password": function () {
      if (this.pwErrMsg) {
        this.checker("pw");
      }
    },
    "validate.password2": function () {
      if (this.pwErrMsg2) {
        this.checker("pw2");
      }
    },
  },
};
</script>


<style lang="scss" scoped>
.container {
  margin: 0 auto;
  min-height: 100vh;
  width: 100%;
  max-width: 400px;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  flex-direction: column;
  .section-title {
    font-size: 24px;
    font-weight: 900;
    margin-bottom: 10px;
  }
  .section-login-form {
    width: 100%;
    padding: 20px;
    .section-input-text {
      display: flex;
      position: relative;
      height: 35px;
      margin-bottom: 25px;
      .mdi {
        margin-top:7px;
      }
    }
    .login-button {
      margin: 15px 0 15px;
    }
  }
}
</style>