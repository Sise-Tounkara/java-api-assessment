# Family Activities API

## Description

The Family Activities API facilitates the management of family activities by allowing users to submit activity details and later retrieve them, including a suggested budget calculated using the provided details.

## Getting Started

### Clone the Repository

Clone this repository:

```sh
git clone [REPO_URL]
cd [REPO_NAME]
```

Replace `[REPO_URL]` with the link to your GitHub repository and `[REPO_NAME]` with the repository's name.

### Install Dependencies

Install dependencies using Maven:

```sh
./mvnw clean dependency:resolve
```

If you are on a Windows machine:

```cmd
mvnw clean dependency:resolve
```

### Running the Application

Start the API from the terminal:

```sh
./mvnw spring-boot:run
```

On Windows:

```cmd
mvnw spring-boot:run
```

### Testing the Application

You can test your endpoints using [Postman](https://www.postman.com/) or your preferred REST client.

## API Endpoints Reference

### Get all activities

```http
GET api/FamilyActivities/
```

### Get activities by type

```http
GET api/FamilyActivities/?type=INDOOR
```

To get all indoor activities only.

```http
GET api/FamilyActivities/?type=OUTDOOR
```

To get all outdoor activities only.

### Get activities sorted by budget

```http
GET api/FamilyActivities/?order=ASCENDING
```

To get all activities in ascending order of their budget amount.

```http
GET api/FamilyActivities/?order=DESCENDING
```

To get all activities in descending order of their budget amount.

### Get activities by type and sorted by budget

```http
GET api/FamilyActivities/?type=INDOOR&order=ASCENDING
```

To get all indoor activities in ascending order.

```http
GET api/FamilyActivities/?type=OUTDOOR&order=DESCENDING
```

To get all outdoor activities in descending order.

### Get activity by ID

```http
GET api/FamilyActivities/${id}
```

| Parameter | Type   | Description                  |
| --------- | ------ | ---------------------------- |
| `id`      | `UUID` | **Required**. ID of the activity to retrieve. |

### Create an activity

```http
POST api/FamilyActivities/
```

And provide the request body in JSON format:

```json
{
  "activityName": "Farmers' Market Visit",
  "activityDescription": "Explore local produce and artisanal goods at the farmers' market with family or friends.",
  "numberOfAdults": 3,
  "numberOfChildren": 2,
  "activityCostPerAdult": 0.00,
  "activityCostPerChild": 0.00,
  "foodCostPerAdult": 10.00,
  "foodCostPerChild": 5.00,
  "activityType": "OUTDOOR"
}
```

### Update an activity

```http
PUT api/FamilyActivities/${id}
```

| Parameter | Type   | Description                  |
| --------- | ------ | ---------------------------- |
| `id`      | `UUID` | **Required**. ID of the activity to update. |

And provide the request body in JSON format of the updated details.

### Delete an activity

```http
DELETE api/FamilyActivities/${id}
```

| Parameter | Type   | Description                  |
| --------- | ------ | ---------------------------- |
| `id`      | `UUID` | **Required**. ID of the activity to delete. |
```
