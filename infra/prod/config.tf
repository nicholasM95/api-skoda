terraform {
  required_providers {

    helm = {
      source  = "hashicorp/helm"
      version = "2.16.1"
    }

    cloudflare = {
      source  = "cloudflare/cloudflare"
      version = "4.46.0"
    }

    aws = {
      source  = "hashicorp/aws"
      version = "5.77.0"
    }
  }

  backend "s3" {
    bucket = "nicholasmeyers-api-skoda-prd-terraform-state"
    key    = "terraform.tfstate"
    region = "eu-west-1"
  }
}

provider "helm" {
  kubernetes {
    config_path = "~/.kube/config"
  }
}
