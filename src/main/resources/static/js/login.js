import { createApp, onMounted, ref } from "./libs/vue.esm-browser.prod.js";

createApp({
    setup() {
        const isBlock = ref(false);
        const message = ref(null);
        const isMessageShow = ref(false);
        
        function signupLinkOnClick(e) {
            isBlock.value = true;
        }

        function signupDialogOnClose(e) {
            isBlock.value = false;
        }

        function signupOnSumbit(e) {
            axios.post("/demo/auth/api/signup", {
                username: "username",
                password: "password"
            })
            .then(function(response) {
                if (response.data === "success") {
                    signupDialogOnClose();
                    message.value.textContent = "Sign Up Success";
                    isMessageShow.value = true;
                }
            })
            .catch(function(error){
                console.log(error);
            });
        }
        return {
            isBlock,
            message,
            isMessageShow,
            signupLinkOnClick,
            signupDialogOnClose,
            signupOnSumbit
        }
    }
}).mount("#app");
