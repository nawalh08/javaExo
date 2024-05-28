import { Button, StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { useDispatch } from 'react-redux'
import { addIds } from '../store/redux/data'

export default function ScreenAdd() {

  const dispatch = useDispatch()

  function getRandom(){
    return Math.floor(Math.random()*100)
  }

  return (
    <View style={styles.container}>
      <Button color={'red'} title="Ajout d'un id random" onPress={() => dispatch(addIds({ id : getRandom()}))} />
    </View>
  )
}

const styles = StyleSheet.create({
    container :{
        flex:1,
        backgroundColor:"black",
        textAlign:'center'
    },
})