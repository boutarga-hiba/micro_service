# Micro-Services App – Guide de test des APIs avec Postman

Ce guide explique comment tester les APIs CRUD de chaque microservice (Customer, Inventory, Billing) avec Postman.

---

## 1. Prérequis
- Démarrer tous les microservices (customer-service, inventory-service, billing-service, etc.)
- Installer [Postman](https://www.postman.com/downloads/)
- Vérifier les ports de chaque service (par défaut :
  - Customer : 8081
  - Inventory : 8082
  - Billing : 8083)

---

## 2. Customer Service (`/customers`)

### a. Lister tous les clients
- **Méthode** : GET
- **URL** : `http://localhost:8081/customers`

### b. Détail d'un client
- **Méthode** : GET
- **URL** : `http://localhost:8081/customers/{id}`

### c. Créer un client
- **Méthode** : POST
- **URL** : `http://localhost:8081/customers`
- **Body (JSON)** :
```json
{
  "name": "John Doe",
  "email": "john@example.com"
}
```

### d. Modifier un client
- **Méthode** : PUT
- **URL** : `http://localhost:8081/customers/{id}`
- **Body (JSON)** :
```json
{
  "name": "Jane Doe",
  "email": "jane@example.com"
}
```

### e. Supprimer un client
- **Méthode** : DELETE
- **URL** : `http://localhost:8081/customers/{id}`

---

## 3. Inventory Service (`/products`)

### a. Lister tous les produits
- **Méthode** : GET
- **URL** : `http://localhost:8082/products`

### b. Détail d'un produit
- **Méthode** : GET
- **URL** : `http://localhost:8082/products/{id}`

### c. Créer un produit
- **Méthode** : POST
- **URL** : `http://localhost:8082/products`
- **Body (JSON)** :
```json
{
  "name": "Laptop",
  "price": 1200,
  "quantity": 10
}
```

### d. Modifier un produit
- **Méthode** : PUT
- **URL** : `http://localhost:8082/products/{id}`
- **Body (JSON)** :
```json
{
  "name": "Laptop Pro",
  "price": 1500,
  "quantity": 5
}
```

### e. Supprimer un produit
- **Méthode** : DELETE
- **URL** : `http://localhost:8082/products/{id}`

---

## 4. Billing Service (`/bills`)

### a. Lister toutes les factures
- **Méthode** : GET
- **URL** : `http://localhost:8083/bills`

### b. Détail d'une facture
- **Méthode** : GET
- **URL** : `http://localhost:8083/bills/{id}`

### c. Créer une facture
- **Méthode** : POST
- **URL** : `http://localhost:8083/bills`
- **Body (JSON)** :
```json
{
  "billingDate": "2024-07-01T00:00:00.000+00:00",
  "customerId": 1
}
```

### d. Modifier une facture
- **Méthode** : PUT
- **URL** : `http://localhost:8083/bills/{id}`
- **Body (JSON)** :
```json
{
  "billingDate": "2024-07-02T00:00:00.000+00:00",
  "customerId": 1
}
```

### e. Supprimer une facture
- **Méthode** : DELETE
- **URL** : `http://localhost:8083/bills/{id}`

---

## 5. Conseils
- Pour POST/PUT, dans Postman, choisis l'onglet **Body** > **raw** > **JSON**.
- Clique sur **Send** pour chaque requête et observe la réponse.
- Adapte les ports si tu as modifié la configuration.

---

## 6. Exemple de collection Postman
Tu peux créer une collection Postman et y ajouter toutes ces requêtes pour automatiser tes tests. 