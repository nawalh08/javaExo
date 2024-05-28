<script setup>
import { ref } from 'vue';

let tab = ref([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
let val = 11
console.table(tab);
function addLine() {
  tab.value.push(val);
  val++
  console.table(tab);
  console.log(val);
 
}
</script>

<template>
  <button>toggle</button>
  <button @click="addLine">ajouter element</button>
  <button>supprimer elements</button>
  <button>Inverser ligne</button>
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
