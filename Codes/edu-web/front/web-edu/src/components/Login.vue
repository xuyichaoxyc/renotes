<template>
  <div class="back">
      <div class="main">
          <div class="card_left">
            <a-card class="card" title="Sign in" style="width: 400px">
              <a slot="extra" href="#">Want Register?</a>
              <a-form  :form="form" @submit="handleSubmit">
                <a-form-item  class="username"  :validate-status="userNameError() ? 'error' : ''" :help="userNameError() || ''">
                  <a-input  size="large"
                    v-decorator="[
                      'userName',
                      { rules: [{ required: true, message: 'Please input your username!' }] },
                    ]"
                    placeholder="Username"
                  >
                    <a-icon slot="prefix" type="user" style="color:rgba(0,0,0,.25)" />
                  </a-input>
                </a-form-item>
                <a-form-item class="password" :validate-status="passwordError() ? 'error' : ''" :help="passwordError() || ''">
                  <a-input-password  size="large" 
                  placeholder="input password"
                  v-decorator="[
                      'password',
                      { rules: [{ required: true, message: 'Please input your Password!' }] },
                    ]"
                    type="password" >
                    <a-icon slot="prefix" type="lock" style="color:rgba(0,0,0,.25)" />
                  </a-input-password>
                </a-form-item>
                <a-form-item>
                    <a-button class="login" size="large" block html-type="submit" :disabled="hasErrors(form.getFieldsError())">
                      Default
                    </a-button>
                </a-form-item>
              </a-form>
            </a-card>
          </div>
            <!-- <br />  换行 -->
          <div class="card_right">
              <a-card class="card2" size="large" hoverable style="width: 500px">
                <template>
                <el-carousel  height="360px" :interval="5000" arrow="always">
                  <el-carousel-item v-for="item in imagesBox" :key="item.id">
                    <!-- <h3>{{ item }}</h3> -->
                    <img class="image" :src="item.idView" width="450px" height="360px">
                  </el-carousel-item>
                </el-carousel>
              </template>
                <a-card-meta title="Europe Street beat">
                  <template slot="description">
                    www.instagram.com
                  </template>
                </a-card-meta>
              </a-card>
        </div>
      </div>

      <!-- 底部 -->
      <!-- <a-divider class="divider"></a-divider>
      <div class="button">
        1111
      </div> -->

  </div>
</template>

<script>
  function hasErrors(fieldsError) {
    return Object.keys(fieldsError).some(field => fieldsError[field]);
  }
  export default {
      name: 'Login',
      data() {
        return {
          hasErrors,
          form: this.$form.createForm(this, { name: 'horizontal_login' }),

          imagesBox: [
              {id:0,idView:require("../assets/1.jpg")},
              {id:1,idView:require("../assets/2.jpg")},
              {id:2,idView:require("../assets/3.jpg")},
            ]
        };
      },
      mounted() {
        this.$nextTick(() => {
          // To disabled submit button at the beginning.
          this.form.validateFields();
        });
      },
      methods: {
        // Only show error after a field is touched.
        userNameError() {
          const { getFieldError, isFieldTouched } = this.form;
          return isFieldTouched('userName') && getFieldError('userName');
        },
        // Only show error after a field is touched.
        passwordError() {
          const { getFieldError, isFieldTouched } = this.form;
          return isFieldTouched('password') && getFieldError('password');
        },
        handleSubmit(e) {
          e.preventDefault();
          this.form.validateFields((err, values) => {
            if (!err) {
              console.log('Received values of form: ', values);
            }
          });
        },
      },
  }
</script>

<style scoped src="../assets/css/login.css"/>