<script setup>
import { ref,onMounted} from 'vue';

let data = ref();
let nbPage = ref(1);

async function getCharacterByPage(page) {

  try {
    const response = await fetch(`https://rickandmortyapi.com/api/character/?page=${page}`);
    if (!response.ok) {
      throw new Error('Erreur lors du chargement des données');
    }
    const jsonData = await response.json();
    data.value = jsonData; 

    console.log(data.value.results);
  } catch (error) {
    console.error('Erreur:', error);
  }
}


onMounted(() => {
  getCharacterByPage(nbPage);
  console.log(data);
});
</script>

<template>
  <section >
    <input @keyup.enter="name = $event.target.value">
  </section>
  
  <section v-if="data" v-for="character in data.results" :key="character.id">
    <h1>{{ character.name }}</h1>
  </section> 

  <button @click="nbPage < 41 ? nbPage++:'', getCharacterByPage(nbPage)">PLUS</button>
  <button @click="nbPage > 1 ? nbPage-- : '', getCharacterByPage(nbPage)">MOINS</button>
</template>

<style scoped>
h1 {
  display: block;
  background-color: white;  
}
</style>
