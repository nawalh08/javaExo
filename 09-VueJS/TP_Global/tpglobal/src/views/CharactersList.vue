<script setup>
const input = document.querySelector("input");
const log = document.getElementById("values");
import FooterComponent from "../components/FooterComponent.vue"
import { ref, onMounted } from 'vue';

import { useCharactersStore } from '../stores/characters'
import Card from '../components/CardComponent.vue';
import HeaderComponent from "@/components/HeaderComponent.vue";
import router from "@/router";

let data = ref();
let nbPage = ref(1);
let gender = ""
let species = ""
let type = ""
let status = ""
let name = ""
let filter = ref(false)


const personnageStore = useCharactersStore();
const { getCharacterByPage } = personnageStore


onMounted(() => {
  getCharacterByPage(nbPage, name, status, gender, species, type);
  console.log(data);
});

function logout(){
  router.push('/')
}

function onChangeGender(event) {

  gender = event.target.value
  console.log(gender);
  nbPage = 1
  getCharacterByPage(nbPage, name, status, gender, species, type);
}
function onChangeStatus(event) {

  status = event.target.value
  console.log(status);
  nbPage = 1
  getCharacterByPage(nbPage, name, status, gender, species, type);
}
function onChangeSpecies(event) {

  species = event.target.value
  console.log(gender);
  nbPage = 1
  getCharacterByPage(nbPage, name, status, gender, species, type);
}
function onChangeType(event) {
  nbPage = 1
  type = event.target.value
  console.log(gender);
  getCharacterByPage(nbPage, name, status, gender, species, type);
}
function handleInput(event) {
  nbPage=1
  name = event.target.value;
  getCharacterByPage(nbPage, name, status, gender, species, type);
}

function clearFilter() {
  gender = ""
  species = ""
  type = ""
  status = ""
  name = ""
  nbPage = 1
  getCharacterByPage(nbPage, name, status, gender, species, type);

  select_Gender.value="";
  select_Status.value="";
  select_Species.value="";
  select_Type.value="";

}






</script>

<template>
  <header>
    <HeaderComponent/>
    <button @click="logout">Logout</button>
    <div class="bg">
    <span v-if="!filter" @click="filter= !filter"><svg xmlns="http://www.w3.org/2000/svg"    width="50" height="50" fill="transparent" stroke="lightgreen" stroke-width="1" class="bi bi-funnel-fill" viewBox="0 0 16 16">
  <path d="M1.5 1.5A.5.5 0 0 1 2 1h12a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.128.334L10 8.692V13.5a.5.5 0 0 1-.342.474l-3 1A.5.5 0 0 1 6 14.5V8.692L1.628 3.834A.5.5 0 0 1 1.5 3.5z"/>
</svg></span>
<span v-else @click="filter= !filter"><svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" stroke="lightgreen" stroke-width="1" class="bi bi-funnel" viewBox="0 0 16 16">
  <path d="M1.5 1.5A.5.5 0 0 1 2 1h12a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.128.334L10 8.692V13.5a.5.5 0 0 1-.342.474l-3 1A.5.5 0 0 1 6 14.5V8.692L1.628 3.834A.5.5 0 0 1 1.5 3.5zm1 .5v1.308l4.372 4.858A.5.5 0 0 1 7 8.5v5.306l2-.666V8.5a.5.5 0 0 1 .128-.334L13.5 3.308V2z"/>
</svg></span>
  
    <div v-if="filter">
      <input class="search" type="text" v-model="name" placeholder="Enter un nom" @input="handleInput" />
      <br />
    
    <label for="select-Gender">Gender</label>
    <select v-if="filter" @change="onChangeGender" id="select_Gender" style="width: 200px;">
      <option value="">---</option>
      <option value="male">Male</option>
      <option value="female">Female</option>
      <option value="genderless">Genderless</option>
      <option value="unknown">Unkown</option>
    </select>
    <label for="select-Status">Status</label>
    <select @change="onChangeStatus" id="select_Status" style="width: 200px;">
      <option value="">---</option>
      <option value="alive">Alive</option>
      <option value="dead">Dead</option>
      <option value="unknown">Unkown</option>
    </select>
    <br>
    <label for="select-Species">Species</label>
    <select @change="onChangeSpecies" id="select_Species" style="width: 200px;">
      <option value="">---</option>
      <option value="human">Human</option>
      <option value="alien">Alien</option>
      <option value="humanoid">Humanoïde</option>
      <option value="unknown">Unkown</option>
      <option value="poopybutthole">Poopybutthole</option>
      <option value="mythological%20Creature">Unkown</option>
      <option value="animal">Animal</option>
      <option value="robot">Robot</option>
      <option value="cronenberg">Cronenberg</option>
      <option value="disease">Disease</option>
    </select>
    <label for="select-type">Type</label>
    <select @change="onChangeType" id="select_Type" style="width: 200px;">
      <option value="">---</option>
      <option value="genetic experiment">Genetic experiment</option>
      <option value="superhuman">Superhuman (Ghost trains summoner)</option>
      <option value="Parasite">Parasite</option>
      <option value="Human with antennae">Human with antennae</option>
      <option value="Human with ants in his eyes">Human with ants in his eyes</option>
      <option value="Fish-Person">Fish-Person</option>
      <option value="Cromulon">Cromulon</option>
      <option value="Self-aware arm">Self-aware arm</option>
      <option value="Cat-Person">Cat-Person</option>
      <option value="Human with baby legs">Human with baby legs</option>
      <option value="Bepisian">Bepisian</option>
      <option value="Hivemind">Hivemind</option>
      <option value="Mytholog">Mytholog</option>
      <option value="Human with giant head">Human with giant head</option>
      <option value="Dog">Dog</option>
      <option value="Bird-Person">Bird-Person</option>
      <option value="Korblock">Korblock</option>
      <option value="Boobloosian">Boobloosian</option>
      <option value="Elephant-Person">Elephant-Person</option>
      <option value="Superhuman">Superhuman</option>
      <option value="Gromflomite">Gromflomite</option>
      <option value="Centaur">Centaur</option>
      <option value="Organic gun">Organic gun</option>
      <option value="Microverse inhabitant">Microverse inhabitant</option>
      <option value="Vampire">Vampire</option>
      <option value="Light bulb-Alien">Light bulb-Alien</option>
      <option value="Animal">Animal</option>
      <option value="Robot-Crocodile hybrid">Robot-Crocodile hybrid</option>
      <option value="Zigerion">Zigerion</option>
      <option value="Giant">Giant</option>
      <option value="Cone-nippled alien">Cone-nippled alien</option>
      <option value="Demon">Demon</option>
      <option value="Shapeshifter">Shapeshifter</option>
      <option value="Game">Game</option>
      <option value="Amoeba-Person">Amoeba-Person</option>
      <option value="Cronenberg">Cronenberg</option>
      <option value="Clone">Clone</option>
      <option value="Robot">Robot</option>
      <option value="Interdimensional gaseous being">Interdimensional gaseous being</option>
      <option value="Flansian">Flansian</option>
      <option value="Zombodian">Zombodian</option>
      <option value="Garblovian">Garblovian</option>
      <option value="Gazorpian">Gazorpian</option>
      <option value="Eat shiter-Person">Eat shiter-Person</option>
      <option value="Goddess">Goddess</option>
      <option value="Gazorpian reproduction robot">Gazorpian reproduction robot</option>
      <option value="Hammerhead-Person">Hammerhead-Person</option>
      <option value="Hole">Hole</option>
      <option value="Tuskfish">Tuskfish</option>
      <option value="Alphabetrian">Alphabetrian</option>
      <option value="Cat">Cat</option>
      <option value="Time God">Time God</option>
      <option value="Unknown-nippled alien">Unknown-nippled alien</option>
      <option value="Krootabulan">Krootabulan</option>
      <option value="Plutonian">Plutonian</option>
      <option value="Jellybean">Jellybean</option>
      <option value="Tentacle alien">Tentacle alien</option>
      <option value="Miniverse inhabitant">Miniverse inhabitant</option>
      <option value="Cyborg">Cyborg</option>
      <option value="Larva alien">Larva alien</option>
      <option value="Snail alien">Snail alien</option>
      <option value="Tinymouth">Tinymouth</option>
      <option value="Lizard-Person">Lizard-Person</option>
      <option value="Alligator-Person">Alligator-Person</option>
      <option value="Monster">Monster</option>
      <option value="Conjoined twin">Conjoined twin</option>
      <option value="Sentient ant colony">Sentient ant colony</option>
      <option value="Human Gazorpian">Human Gazorpian</option>
      <option value="Boobie buyer reptilian">Boobie buyer reptilian</option>
      <option value="Meeseeks">Meeseeks</option>
      <option value="The Devil">The Devil</option>
      <option value="Cat controlled dead lady">Cat controlled dead lady</option>
      <option value="Numbericon">Numbericon</option>
      <option value="Octopus-Person">Octopus-Person</option>
      <option value="Hairy alien">Hairy alien</option>
      <option value="Pickle">Pickle</option>
      <option value="Bread">Bread</option>
      <option value="Mega Gargantuan">Mega Gargantuan</option>
      <option value="Rat">Rat</option>
      <option value="Gear-Person">Gear-Person</option>
      <option value="Blue ape alien">Blue ape alien</option>
      <option value="Ring-nippled alien">Ring-nippled alien</option>
      <option value="Lobster-Alien">Lobster-Alien</option>
      <option value="Scrotian">Scrotian</option>
      <option value="Shimshamian">Shimshamian</option>
      <option value="Omniscient being">Omniscient being</option>
      <option value="Slug">Slug</option>
      <option value="Stair goblin">Stair goblin</option>
      <option value="Leprechaun">Leprechaun</option>
      <option value="Morty's toxic side">Morty's toxic side</option>
      <option value="Rick's toxic side">Rick's toxic side</option>
      <option value="Traflorkian">Traflorkian</option>
      <option value="Teenyverse inhabitant">Teenyverse inhabitant</option>
      <option value="Trunk-Person">Trunk-Person</option>
      <option value="Tumblorkian">Tumblorkian</option>
      <option value="Chair">Chair</option>
      <option value="Drumbloxian">Drumbloxian</option>
      <option value="Floop Floopian">Floop Floopian</option>
      <option value="Greebybobe">Greebybobe</option>
      <option value="Corn-person">Corn-person</option>
      <option value="Phone-Person">Phone-Person</option>
      <option value="Teddy Bear">Teddy Bear</option>
      <option value="Little Human">Little Human</option>
      <option value="Mexican">Mexican</option>
      <option value="Giant Cat Monster">Giant Cat Monster</option>
      <option value="Old Amazons">Old Amazons</option>
      <option value="Mannie">Mannie</option>
      <option value="Necrophiliac">Necrophiliac</option>
      <option value="Eel">Eel</option>
      <option value="Pizza">Pizza</option>
      <option value="Grandma">Grandma</option>
      <option value="Phone">Phone</option>
      <option value="Doopidoo">Doopidoo</option>
      <option value="Pripudlian">Pripudlian</option>
      <option value="Nano Alien">Nano Alien</option>
      <option value="Human with a flower in his head">Human with a flower in his head</option>
      <option value="Hologram">Hologram</option>
      <option value="Shrimp">Shrimp</option>
      <option value="Caterpillar">Caterpillar</option>
      <option value="Wasp">Wasp</option>
      <option value="Toy">Toy</option>
      <option value="Monogatron">Monogatron</option>
      <option value="Lizard">Lizard</option>
      <option value="Fly">Fly</option>
      <option value="God">God</option>
      <option value="Dummy">Dummy</option>
      <option value="Human with tusks">Human with tusks</option>
      <option value="Gramuflackian">Gramuflackian</option>
      <option value="Dragon">Dragon</option>
      <option value="Snake">Snake</option>
      <option value="Human-Snake hybrid">Human-Snake hybrid</option>
      <option value="Soulless Puppet">Soulless Puppet</option>
      <option value="Half Soulless Puppet">Half Soulless Puppet</option>
      <option value="Glorzo">Glorzo</option>
      <option value="Planet">Planet</option>
      <option value="Zeus">Zeus</option>
      <option value="Clay-Person">Clay-Person</option>
      <option value="Sexy Aquaman">Sexy Aquaman</option>
      <option value="Narnian">Narnian</option>
      <option value="Starfish">Starfish</option>
      <option value="Squid">Squid</option>
      <option value="Decoy">Decoy</option>
      <option value="Whenwolf">Whenwolf</option>
      <option value="Summon">Summon</option>
      <option value="Morglutzian">Morglutzian</option>
      <option value="Weasel">Weasel</option>
      <option value="Super Sperm Monster">Super Sperm Monster</option>
      <option value="CHUD">CHUD</option>
      <option value="Giant Incest Baby">Giant Incest Baby</option>
      <option value="CHUD Human Mix">CHUD Human Mix</option>
      <option value="Changeformer">Changeformer</option>
      <option value="Artificial Intelligence">Artificial Intelligence</option>
      <option value="Guinea Pig for the Polio Vaccine">Guinea Pig for the Polio Vaccine</option>
      <option value="Turkey">Turkey</option>
      <option value="Turkey Human Mix">Turkey Human Mix</option>
      <option value="Anime">Anime</option>
      <option value="Memory">Memory</option>
      <option value="Bird-Person Human Mix">Bird-Person Human Mix</option>
      <option value="Crow">Crow</option>
      <option value="Cookie">Cookie</option>
      <option value="Normal Size Bug">Normal Size Bug</option>
      <option value="Slartivartian">Slartivartian</option>
      <option value="Ferkusian">Ferkusian</option>
      <option value="Mascot">Mascot</option>
      <option value="Scarecrow">Scarecrow</option>
      <option value="Tiger">Tiger</option>
      <option value="Crow Horse">Crow Horse</option>
      <option value="Ferret Robot">Ferret Robot</option>
      <option value="Passing Butter Robot">Passing Butter Robot</option>
    </select>
    <br>
 
    <button @click="clearFilter">Clear filter</button>
  </div>
  </div>
  </header>
  <div class="bg">
  <div class="character-card-container">
    <Card v-if="personnageStore.data" v-for="character in personnageStore.data.results" :key="character.id"
      :character-list="character" :id="character.id" />
  </div>

  <div class="naviguation">
    <button @click="nbPage = 1, getCharacterByPage(nbPage, name, status, gender, species, type);;">FIRST</button>
    <button @click="nbPage > 1 ? nbPage-- : '', getCharacterByPage(nbPage, name, status, gender, species, type);"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left-circle" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0m-4.5-.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5z"/>
</svg></button>
    <input type="number" placeholder=nbPage v-model="nbPage"
      @keyup.enter="nbPage = $event.target.value, getCharacterByPage(nbPage, name, status, gender, species, type);">

    <button
      @click="nbPage < (personnageStore.data.info.pages - 1) ? nbPage++ : '', getCharacterByPage(nbPage, name, status, gender, species, type);"><svg
        xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-circle"
        viewBox="0 0 16 16">
        <path fill-rule="evenodd"
          d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5z" />
      </svg></button>
    <button
      @click="nbPage = personnageStore.data.info.pages, getCharacterByPage(nbPage, name, status, gender, species, type);;">LAST</button>
  </div>
</div>
  <footer>
    <FooterComponent/>
    </footer>
</template>



<style scoped>


.naviguation {
  display: flex;
  justify-content: center;

}
.naviguation>button{
  background-color: white;
  border: thick solid greenyellow;
  border-radius: none;
  margin: 0 1px;
  width: 100px;
  height: 50px;
}

.character-card-container {
  margin-top: 1rem;
  margin-bottom: 1rem;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  row-gap: 10px;
  column-gap: 15px;
  justify-content: center;
  justify-items: center;
  
}

.search {
  border: thick solid greenyellow;
  border-radius: 100px;
  width: 450px;
}

header {
  text-align: center;
}

select {
  border: thick solid greenyellow;
  border-radius: 100px;
}


</style>
