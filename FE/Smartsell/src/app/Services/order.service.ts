import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../Model/Order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

    private apiUrl = 'http://localhost:8080/order'; // Update with your backend API URL
  
    constructor(private http: HttpClient) { }
  
    placeOrder(order: Order): Observable<number> {
      return this.http.post<number>(`${this.apiUrl}/placeorder`, order);
    }
  
    getOrderDetails(orderId: number): Observable<Order> {
      return this.http.get<Order>(`${this.apiUrl}/${orderId}`);
    }
  
    updateOrder(orderId: number, order: Order): Observable<Order> {
      return this.http.put<Order>(`${this.apiUrl}/update/${orderId}`, order);
    }
  
  
}
