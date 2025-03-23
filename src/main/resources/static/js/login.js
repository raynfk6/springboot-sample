import { createApp, ref } from "./libs/vue.esm-browser.prod.js";

createApp({
    setup() {
        const message = ref('Hello Vue!');
        return {
            message
        }
    }
}).mount('#app');