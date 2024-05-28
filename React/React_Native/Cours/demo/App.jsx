import { Button, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import AsyncStorage from '@react-native-async-storage/async-storage'

export default function App() {

  const [nom,setNom] = useState("")
  const [prenom,setPrenom] = useState("")
  const myObject = {
    nom : "Doe",
    prenom : "John",
   
  }
  


  const addData = async () => {
    try{
      await AsyncStorage.setItem('key',JSON.stringify(myObject))
    }catch(error){
      console.log(error)
    }
  }

  const recupData = async () => {
    try{
      const value =  JSON.parse(await AsyncStorage.getItem('key'))
      if(value !== null){
        setNom(value.nom)
        setPrenom(value.prenom)
        console.log(value);
      }
    }catch(error){
      console.log(error)
    }
  }

  const deleteData = async () => {
    try{
      await AsyncStorage.removeItem('key')
      setNom('')
      setPrenom('')
    }catch(error){
      console.log(error)
    }
  }


  return (
    <View>
      <Text>Nom: {nom}</Text>
      <Text>Prenom : {prenom}</Text>
      <Button title='Ajout' onPress={addData}/>
      <Button title='Recup' onPress={recupData}/>
      <Button title='Delete' onPress={deleteData}/>
    </View>
  )
}

const styles = StyleSheet.create({})