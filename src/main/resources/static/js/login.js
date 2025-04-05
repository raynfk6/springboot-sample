import { createApp, onMounted, ref } from "./libs/vue.esm-browser.prod.js";

createApp({
    setup() {
        const isBlock = ref(false);
        const message = ref(null);
        const isMessageShow = ref(false);
        const projectTypes = ref([
            { id: "coreCheckBox", text: "核心", val: "core", checked: false },
            { id: "nonCoreCheckBox", text: "非核心", val: "nonCore", checked: false }
        ])
        
        function signupLinkOnClick(e) {
            isBlock.value = true;
        }

        function signupDialogOnClose(e) {
            isBlock.value = false;
        }

        function signupOnSumbit(e) {
            let projectType = "";
            if (projectTypes.value[0].checked && projectTypes.value[1].checked) {
                projectType = "both";
            } else if (projectTypes.value[0].checked) {
                projectType = projectTypes.value[0].val;
            } else if (projectTypes.value[1].checked) {
                projectType = projectTypes.value[1].val;
            } else {
                // 一定要選之提示
                alert("must to choose 1");
                return ;
            }
            
            axios.post("/demo/auth/api/signup", {
                // 要改成抓輸入
                username: "username",
                password: "password",
                projectType: projectType
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
            projectTypes,
            signupLinkOnClick,
            signupDialogOnClose,
            signupOnSumbit
        }
    }
}).mount("#app");
