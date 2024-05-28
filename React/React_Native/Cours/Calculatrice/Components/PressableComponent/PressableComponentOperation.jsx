import { StyleSheet, Text, View,Pressable } from 'react-native'
import React from 'react'

export default function PressableComponentOperation(props) {
    
  return (
    <View>
      <Pressable style={styles.Test} onPress={() =>{props.setOperator(props.value) ,props.handleSubmit()}}>        
            <Text>{props.value}</Text>       
            </Pressable>
    </View>
  )
}

const styles = StyleSheet.create({
    Test:{
         
        backgroundColor:'gray',
        borderRadius:50,
        width :25,
        height :25     
    }
})