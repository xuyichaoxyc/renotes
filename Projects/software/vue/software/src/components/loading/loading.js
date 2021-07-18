import Vue from 'vue'
import Loading from './loading.vue'

const loadingDirective = {
    inserted(el, binding) {
        const loadingCtor = Vue.extend(Loading)
        const loadingComp = new loadingCtor().$mount()

        el.instance = loadingComp

        if(binding.value) {
            append(el)
        }
        console.log('loadingComp', loadingComp.$mount)
    },
    updated(el, binding) {

    }
}

function append(el) {
    el.appendChild(el,instance.$el)
}

export default loadingDirective