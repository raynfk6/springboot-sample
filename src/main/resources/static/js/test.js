import { createApp, ref } from "./libs/vue.esm-browser.prod.js";
import { createRouter, createWebHashHistory } from "./libs/vue-router.esm-browser.prod.js";

const Home = { template: "<h1>home</h1>" }
const About = { template: "<h1>About</h1>" }

const routes = [
    { path: "/", component: Home },
    { path: "/about", component: About }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})


createApp({
    template: `<div>
                <h1>Vue 3 + Vue Router no NPM</h1>
                <nav>
                    <a href="#/">home</a> | 
                    <a href="#/about">about</a>
                </nav>
                <div>{{ message }}</div>
                <router-view></router-view>
                </div>`
,
    setup() {
        const message = ref('Hello Vue!');
        return {
            message
        }
    }
}).use(router).mount("#app");