import { vehicleFormat } from "./vehicleFormat";

export interface vehicleCartFormat{
    cartId:String,
    username:String,
    vehicle:{
        vehicleId:"",
        vehicleType:"",
        vehicleModel:"",
        vehicleManufDate:""
    }
}