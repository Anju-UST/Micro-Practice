import { Component } from '@angular/core';
import { Order } from '../Model/order';
import { OrderService } from '../Service/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent {
  orderId: number | undefined;
  order: Order | undefined;
  updatedOrder: Order | undefined;

  constructor(private orderService: OrderService) { }

  placeOrder(order: any): void {
    this.orderService.placeOrder(order).subscribe(
      orderId => {
        console.log('Order placed successfully with ID:', orderId);
        // Perform any additional actions after placing the order
      },
      error => {
        console.error('Failed to place order:', error);
      }
    );
  }

  getOrderDetails(orderId: number): void {
    this.orderService.getOrderDetails(orderId).subscribe(
      order => {
        console.log('Order details:', order);
        // Use the order details as needed
      },
      error => {
        console.error('Failed to retrieve order details:', error);
      }
    );
  }

  updateOrder(orderId: number, updatedOrder: any): void {
    this.orderService.updateOrder(orderId, updatedOrder).subscribe(
      order => {
        console.log('Order updated successfully:', order);
        // Perform any additional actions after updating the order
      },
      error => {
        console.error('Failed to update order:', error);
      }
    );
  }
}


