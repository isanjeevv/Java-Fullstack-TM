import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class CarsPage extends StatelessWidget {
  const CarsPage({super.key});

  @override
  Widget build(BuildContext context) {
    // Initialize Firestore collection inside the build method
    final CollectionReference carsCollection =
        FirebaseFirestore.instance.collection('cars');

    return Scaffold(
      appBar: AppBar(title: Text('Cars Wallpapers')),
      body: StreamBuilder(
        stream: carsCollection.snapshots(),
        builder: (context, AsyncSnapshot<QuerySnapshot> snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return Center(child: CircularProgressIndicator());
          }
          if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
            return Center(child: Text('No images added yet.'));
          }

          return GridView.builder(
            padding: EdgeInsets.all(8),
            gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
              crossAxisCount: 2,
              crossAxisSpacing: 8,
              mainAxisSpacing: 8,
            ),
            itemCount: snapshot.data!.docs.length,
            itemBuilder: (context, index) {
              final DocumentSnapshot carImage = snapshot.data!.docs[index];
              String imageUrl = carImage['url'];

              return Stack(
                children: [
                  ClipRRect(
                    borderRadius: BorderRadius.circular(10),
                    child: Image.network(imageUrl, fit: BoxFit.cover),
                  ),
                  Positioned(
                    top: 5,
                    right: 5,
                    child: IconButton(
                      icon: Icon(Icons.delete, color: Colors.red),
                      onPressed: () => _deleteImage(carImage.id),
                    ),
                  ),
                ],
              );
            },
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.pushNamed(context, '/add_image', arguments: 'cars');
        },
        child: Icon(Icons.add),
      ),
    );
  }

  void _deleteImage(String docId) {
    FirebaseFirestore.instance.collection('cars').doc(docId).delete();
  }
}
