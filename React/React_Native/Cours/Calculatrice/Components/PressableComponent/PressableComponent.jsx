import { StyleSheet, Text, View,Pressable } from 'react-native'
import React from 'react'

export default function PressableComponent(props) {
  
    
  return (
    <View>
        {props.type=='Number'?  <Pressable style={styles.Test} onPress={() =>props.setCurrentValue(props.CurrentValue + props.value)}>        
            <Text style={styles.TextStyle}>{props.value}</Text>       
            </Pressable> :  <Pressable style={styles.Test2}  onPress={()  =>{props.setOperator&&(props.setOperator(props.value)) ,props.handleSubmit()}}>        
            <Text style={styles.TextStyle}>{props.value}</Text>       
            </Pressable> }
     
    </View>
  )
}


    const styles = StyleSheet.create({
        Test:{
           margin:25, 
            backgroundColor : 'white',
            borderRadius :50,
            width :50,
        height :50,
        
        justifyContent:'center'
        },
        Test2:{
           margin:25, 
            backgroundColor : 'gray',
            borderRadius :50,
            width :50,
        height :50,
        
        justifyContent:'center'
        },
        TextStyle:{
            textAlign:'center'
        }
    })
