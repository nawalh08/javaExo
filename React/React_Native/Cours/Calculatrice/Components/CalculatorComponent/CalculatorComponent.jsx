import { Button, Image, StyleSheet, Text, View, Pressable } from 'react-native'
import React from 'react'
import PressableComponent from '../PressableComponent/PressableComponent'
import PressableComponentOperation from '../PressableComponent/PressableComponentOperation'





export default function Calculator() {
    const [CurrentValue, setCurrentValue] = React.useState("")
    const [MemoryValue, setMemoryValue] = React.useState("")
    const [ResultValue, setResultValue] = React.useState("")
    const [Operator, setOperator] = React.useState("")

    console.log(CurrentValue);
    function handleSubmit() {
        setMemoryValue(CurrentValue)
        setCurrentValue("")
    }
    function ValidateOperation() {

        let test = (MemoryValue + " " + Operator + " " + CurrentValue)

        setResultValue(eval(test))
    }
    function sup(){
        if(CurrentValue.length>0){
            setCurrentValue(CurrentValue.slice(0,-1))
        }
    }
    return (
        <View>
            <Text style={styles.TextStyle2} >Valeur actuelle : {CurrentValue}</Text>
            <Text style={styles.TextStyle2}>Valuer Enregistrée : {MemoryValue}</Text>
            <Text style={styles.TextStyle2}>Resultat : {ResultValue}</Text>
            <View style={styles.row}>
                <Pressable style={styles.Test} onPress={() => { setCurrentValue(""), setMemoryValue(""), setResultValue(""), setOperator("") }}><Text style={styles.TextStyle}>AC</Text></Pressable>             
                <PressableComponent type="Operator" value='^' setOperator={setOperator} setCurrentValue={setCurrentValue} setMemoryValue={setMemoryValue} handleSubmit={handleSubmit} CurrentValue={CurrentValue} MemoryValue={MemoryValue}/>
                <PressableComponent type="Operator" value='%' setOperator={setOperator} setCurrentValue={setCurrentValue} setMemoryValue={setMemoryValue} handleSubmit={handleSubmit} CurrentValue={CurrentValue} MemoryValue={MemoryValue}/>
                <PressableComponent type="Operator" value='/' setOperator={setOperator} setCurrentValue={setCurrentValue} setMemoryValue={setMemoryValue} handleSubmit={handleSubmit} CurrentValue={CurrentValue} MemoryValue={MemoryValue}/>                              
            </View>
            <View style={styles.row}>
                <PressableComponent type="Number" value='7' setCurrentValue={setCurrentValue} CurrentValue={CurrentValue} />
                <PressableComponent type="Number" value='8' setCurrentValue={setCurrentValue} CurrentValue={CurrentValue} />
                <PressableComponent type="Number" value='9' setCurrentValue={setCurrentValue} CurrentValue={CurrentValue} />
                <PressableComponent type="Operator" value='*' setOperator={setOperator} setCurrentValue={setCurrentValue} setMemoryValue={setMemoryValue} handleSubmit={handleSubmit} CurrentValue={CurrentValue} MemoryValue={MemoryValue}/>
            </View>
            <View style={styles.row}>
                <PressableComponent type="Number" value='4' setCurrentValue={setCurrentValue} CurrentValue={CurrentValue} />
                <PressableComponent type="Number" value='5' setCurrentValue={setCurrentValue} CurrentValue={CurrentValue} />
                <PressableComponent type="Number" value='6' setCurrentValue={setCurrentValue} CurrentValue={CurrentValue} />
                <PressableComponent  type="Operator" value='-' setOperator={setOperator} setCurrentValue={setCurrentValue} setMemoryValue={setMemoryValue} handleSubmit={handleSubmit} CurrentValue={CurrentValue} MemoryValue={MemoryValue}/>
            </View>
            <View style={styles.row}>
                <PressableComponent type="Number" value='1' setCurrentValue={setCurrentValue} CurrentValue={CurrentValue} />
                <PressableComponent type="Number" value='2' setCurrentValue={setCurrentValue} CurrentValue={CurrentValue} />
                <PressableComponent type="Number" value='3' setCurrentValue={setCurrentValue} CurrentValue={CurrentValue} />
                <PressableComponent  type="Operator" value='+' setOperator={setOperator} setCurrentValue={setCurrentValue} setMemoryValue={setMemoryValue} handleSubmit={handleSubmit} CurrentValue={CurrentValue} MemoryValue={MemoryValue}/>
            </View>
            <View style={styles.row}>
                <PressableComponent type="Number" value='.' setCurrentValue={setCurrentValue} CurrentValue={CurrentValue} />
                <PressableComponent type="Number" value='0' setCurrentValue={setCurrentValue} CurrentValue={CurrentValue} />
                <Pressable style={styles.Test2} onPress={() => { sup() }}><Text style={styles.TextStyle}>DEL</Text></Pressable> 
                <PressableComponent type="Operator" value='='  setCurrentValue={setCurrentValue} setMemoryValue={setMemoryValue} CurrentValue={CurrentValue} MemoryValue={MemoryValue} handleSubmit={ValidateOperation}/>
                          
               
            </View>

        </View>
    )
}
const styles = StyleSheet.create({
    row:{
        flexDirection:'row',        
    },    
    Test:{
        
        margin:25, 
        backgroundColor : 'gray',
        borderRadius :50,
        width :50,
    height :50 ,
    justifyContent:'center',
    textAlign:'center'
       
     
    },
    Test2:{
        
        margin:25, 
        backgroundColor : 'white',
        borderRadius :50,
        width :50,
    height :50 ,
    justifyContent:'center',
    textAlign:'center'
       
     
    },
    TextStyle:{
        textAlign:'center',
        color:'black'
    },
    TextStyle2:{        
        color:'white'
    }
 

})
