# Box Subscription Management System - Cloud Backend

## Overview

This folder contains Google Cloud Functions for the Box Subscription Management System backend.

## Structure

```
cloud/
├── functions/                      # Cloud Functions
│   ├── auth/                      # Authentication functions
│   ├── subscription/              # Subscription management
│   ├── payment/                   # Payment processing with Stripe
│   ├── notification/              # Email notifications
│   ├── shipment/                  # Shipment management
│   ├── inventory/                 # Inventory management
│   └── analytics/                 # Reports and analytics
├── firestore/                     # Firestore database
│   ├── rules/                     # Security rules
│   └── indexes/                   # Database indexes
├── storage/                       # Cloud Storage
│   └── rules/                     # Storage rules
├── pubsub/                        # Pub/Sub Topics
│   ├── topics/                    # Topic definitions
│   └── subscriptions/             # Subscription definitions
└── scheduler/                     # Cloud Scheduler jobs
```

## Firebase/Firestore Collections

### Users Collection

```
users/{userId}
  - email: string
  - name: string
  - phone: string
  - role: string (admin/subscriber)
  - createdAt: timestamp
  - updatedAt: timestamp
```

### Subscriptions Collection

```
subscriptions/{subscriptionId}
  - userId: string
  - planId: string
  - status: string (active/paused/cancelled)
  - startDate: timestamp
  - nextBillingDate: timestamp
  - autoRenew: boolean
```

### Payments Collection

```
payments/{paymentId}
  - userId: string
  - subscriptionId: string
  - amount: number
  - status: string
  - stripePaymentId: string
  - transactionDate: timestamp
```

### Orders Collection

```
orders/{orderId}
  - userId: string
  - subscriptionId: string
  - items: array
  - total: number
  - status: string
  - createdAt: timestamp
```

### Shipments Collection

```
shipments/{shipmentId}
  - orderId: string
  - trackingNumber: string
  - carrier: string
  - status: string
  - estimatedDelivery: timestamp
```

## Cloud Functions

### Authentication Functions

- `authLogin` - Handle user login
- `authRegister` - Handle user registration
- `authRefreshToken` - Refresh JWT tokens

### Subscription Functions

- `createSubscription` - Create new subscription
- `updateSubscription` - Update subscription status
- `processRenewal` - Process automatic renewals (scheduled)

### Payment Functions

- `processPayment` - Process one-time payment
- `setupRecurringPayment` - Setup recurring billing with Stripe
- `handleStripeWebhook` - Handle Stripe webhook events

### Notification Functions

- `sendRenewalReminder` - Send renewal reminders (scheduled)
- `sendShipmentNotification` - Send shipment updates
- `sendPaymentConfirmation` - Send payment confirmations

### Shipment Functions

- `generateManifest` - Generate shipping manifest
- `updateShipmentStatus` - Update shipment tracking

### Inventory Functions

- `allocateInventory` - Allocate products to orders
- `updateInventoryLevels` - Update inventory quantities

### Analytics Functions

- `calculateChurnRate` - Calculate churn rate
- `generateRevenueReport` - Generate revenue reports
- `getActiveSubscribers` - Get active subscriber count

## Deployment

### Prerequisites

1. Install Firebase CLI: `npm install -g firebase-tools`
2. Login to Firebase: `firebase login`
3. Initialize project: `firebase init`

### Deploy Functions

```bash
firebase deploy --only functions
```

### Deploy Firestore Rules

```bash
firebase deploy --only firestore:rules
```

### Deploy Storage Rules

```bash
firebase deploy --only storage
```

## Environment Variables

Set in Firebase Functions configuration:

```bash
firebase functions:config:set \
  stripe.secret_key="your_stripe_secret_key" \
  sendgrid.api_key="your_sendgrid_api_key" \
  app.base_url="your_app_url"
```

## Monitoring

- View logs: `firebase functions:log`
- Monitor in Firebase Console: <https://console.firebase.google.com>
- Set up alerts for function errors and performance

## Security

- All functions require authentication except public endpoints
- Firestore security rules enforce data access control
- Stripe webhook signatures are verified
- Sensitive data is encrypted at rest

## Cost Optimization

- Use Cloud Scheduler for periodic tasks
- Implement caching for frequently accessed data
- Set appropriate function timeout limits
- Use Pub/Sub for asynchronous operations
