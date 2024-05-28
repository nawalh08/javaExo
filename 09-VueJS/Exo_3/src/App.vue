<script setup>
import HelloWorld from './components/HelloWorld.vue'
import TheWelcome from './components/TheWelcome.vue'
import { ref, computed } from 'vue';
let error = ref(null);
let classes = computed(() => {
  return { "selected": Rouge.value, "text-error": Bleu.value && error.value }
});

function togglecolor(){
  if(color.value==='red'){
    color.value = 'blue'
  }else{
    color.value='red'
  }
}
let color = ref('red')

let Rouge = ref(false);
let Bleu = ref(false);

</script>

<template>
  <p :class="classes" @click="Rouge = !Rouge">Premier paragraphe</p>
  

  <p  :style="{color}" @click="togglecolor()">Deuxième paragraphe</p>
</template>

<style scoped>
.selected{
  color: red;
}

.text-error{
  color: black;
}
.text-blue{
  color: blue;
}
</style>
